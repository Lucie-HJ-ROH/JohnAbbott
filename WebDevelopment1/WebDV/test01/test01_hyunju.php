<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Comment</title>
    <style>
        form {

            background-color: lightgray;
            width: 80%;
        }

        form div {
            margin: 10px;

        }

        .error {
            color: red;
        }
    </style>
</head>
<body>
<?php
//set some empty variables
$emailErr = $passwordErr = $repasswordErr = $first_nameErr = $last_nameErr = $phoneErr = $addressErr = $townErr = $regionErr
    = $postcodeErr = $countryErr = "";

$email = $password = $repassword = $first_name = $last_name = $phone = $address = $address2 = $town
    = $region = $postcode = $country = "";


$NewUser ="Email : " . $_POST['email']  . " password : " . $_POST['password'] . " repassword :" . $_POST['repassword'] . " first_name : " . $_POST['first_name'] .
    " last_name : " . $_POST['last_name'] . " phone_number : " .    $_POST['phone'] . "address : " . $_POST['address'] . " address2: " . $_POST['address2'] .
    " town : " . $_POST['town']  . " region : " . $_POST['region'] . " postcode : " . $_POST['postcode'] . "country : " . $_POST['country'];

$savedFile = "user.txt";

if (file_put_contents($savedFile, $NewUser, FILE_APPEND) < 0) {
    echo "<p> Registration successful!</p>";

}

$userfile = fopen("user.txt", "w");
fwrite($userfile, $NewUser);
fclose($userfile);


function test_input($data)
{
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (empty($_POST["email"])) {
        $emailErr = "Email is required";
    } else {
        $emailErr = "";
        $email = test_input($_POST["email"]);
        if (!preg_match("/([\w\-]+\@[\w\-]+\.[\w\-]+)/", $email)) {
            $emailErr = "Invalid email format";
        }
    }


    if (empty($_POST["password"])) {
        $passwordErr = "Password is required";
    } else {
        $passwordErr = "";
        $password = test_input($_POST["password"]);

        $num = preg_match('@[0-9]@', $password);
        $eng = preg_match('@[a-z]@', $password);
        $engU = preg_match('@[A-Z]@', $password);
        $spe = preg_match('@[^\w]@', $password);


        if (!$num  || !$eng  || !$spe || !$engU  || strlen($password) < 10) {
            $passwordErr = "The password should be at least 10 chars and include exactly one special character, one uppercase letter and one digit";
        }
    }

    if (empty($_POST["$repassword"])){
        $rePasswordErr = "Retype password is required";
    } else if ($_POST["password"] == $_POST["$repassword"]){
        $repassword = test_input($_POST["$repassword"]);
    } else {
        $repasswordErr = "Password is not same as expected";
    }

    if (empty($_POST["first_name"])) {
        $first_nameErr = "First name is required";
    } else {
        $first_nameErr = "";
        $first_name = test_input($_POST["first_name"]);

        if (!preg_match("/^[A-Z]{1,10}$/", $first_name) && !preg_match("/^\s/u$/", $first_name)) {
            $first_nameErr = "First name must have up to 10 chars, only letters [A-Z], with no space";
        }
    }

    if (empty($_POST["last_name"])) {
        $last_nameErr = "Last name is required";
    } else {
        $last_nameErr = "";
        $last_name = test_input($_POST["last_name"]);

        if (!preg_match("/^[A-Z]{1,15}$/", $last_name)) {
            $last_nameErr = "Last name must have up to 15 chars, only letters [A-Z), with no more than one blank space";
        }
    }

    if (empty($_POST["address"])) {
        $addressErr = "Address is required";
    } else {
        $addressErr = "";
        $address = test_input($_POST["address"]);
        if (!preg_match('/^\\d+ [a-zA-Z ]+, \\d+ [a-zA-Z ]+, [a-zA-Z ]+$/', $address)) {
            $addressErr = "Address entry should contain street number and street name separated with blank space";
        }
    }

    if (empty($_POST["phone"])) {
        $phoneErr = "Phone number is required";
    } else {
        $phoneErr = "";
        $phone = test_input($_POST["phone"]);
        if (!preg_match("/^[+][0-9]{1,15}$/", $phone)) {
            $phoneErr = "Phone number entry should start with a ‘+’ followed by up to 15 digits.";
        }

    }

    if (!empty($_POST["town"])){
        $townErr ="";
        $town = test_input($_POST["town"]);
        if (!preg_match("/^{1,15}$/", $town)) {
            $townErr = "Town is an optional entry with up to 15 characters without space.";
        }
    }
    if (empty($_POST["region"])) {
        $regionErr = "Region is required";
    } else {
        $regionErr = "";
        $region = test_input($_POST["region"]);
        if (!preg_match("/^[A-Z]{2,3}$/", $region)) {
            $regionErr = "Region entry takes between 2 to 3 letters [A-Z].";
        }
    }


    if (empty($_POST["postcode"])) {
        $postcodeErr = "Postal code is required";
    } else {
        $postcodeErr = "";
        $postcode = test_input($_POST["postcode"]);
        if (!preg_match("/^[A-Z][0-9][A-Z][ -]?[0-9][A-Z][0-9]$/", $postcode)) {
            $postcodeErr = "1st, 3rd and 5th char are [A-Z], 2nd, 4th and 6th are the digits[0-9] ";
        }

    }

    if (empty($_POST["country"])) {
        $countryErr = "Country is required";
    } else {
        $country = test_input($_POST["country"]);
        if (!preg_match("/^[A-Z][a-z]{1,15}$/", $country)) {
            $countryErr = "Only uppercase letters less than 15 characters are allowed";
        }
    }


}


?>
<form method="post" action="<?php echo $_SERVER["PHP_SELF"]; ?>">
    <h1>USER REGISTRATION</h1>
    <h4> Fields marked * are required.</h4>
    <div>
        Email *: <input type="text" name="email" value="<?= (isset($email)) ? $email : ''; ?>"><br>
        <span class="error"><?= $emailErr ?></span>
    </div>
    <div>
        Password *: <input type="password" name="password" value="<?= (isset($password)) ? $password : ''; ?>"><br>
        <span class="error"><?= $passwordErr ?></span>
    </div>
    <div>
        Retype Password *: <input type="password" name="repassword"
                                  value="<?= (isset($repassword)) ? $repassword : ''; ?>"><br>
        <span class="error"><?= $repasswordErr ?></span>
    </div>

    <div>
        First Name *: <input type="text" name="first_name" value="<?= (isset($first_name)) ? $first_name : ''; ?>"><br>
        <span class="error"><?= $first_nameErr ?></span>
    </div>
    <div>
        Last Name *: <input type="text" name="last_name"
                              value="<?= (isset($last_name)) ? $last_name : ''; ?>"><br>
        <span class="error"><?= $last_nameErr ?></span>
    </div>
    <div>
        Phone number *: <input type="text" name="phone" value="<?= (isset($phone)) ? $phone : ''; ?>">
        <span class="error"><?= $phoneErr ?></span>
    </div>
    <div>
        Address *: <input type="text" name="address" value="<?= (isset($address)) ? $address : ''; ?>"><br>
        <input type="text" name="address2" value="<?= (isset($address2)) ? $address2 : ''; ?>"><br>
        <span class="error"><?= $addressErr ?></span>
    </div>
    <div>
        town : <input type="text" name="town" value="<?= (isset($town)) ? $town : ''; ?>">
        <span class="error"><?= $townErr ?></span>
    </div>

    <div>
        region *: <input type="text" name="region" value="<?= (isset($region)) ? $region : ''; ?>"><br>
        <span class="error"><?= $regionErr ?></span>
    </div>

    <div>
        Postcode/Zip * : <input type="text" name="postcode" value="<?= (isset($postcode)) ? $postcode : ''; ?>"><br>
        <span class="error"><?= $postcodeErr ?></span>
    </div>

    <div>
        Country * : <input type="text" name="country" value="<?= (isset($country)) ? $country : ''; ?>"><br>
        <span class="error"><?= $countryErr ?></span>
    </div>


    <div><input type="submit" name="submit" value="Submit"></div>
</form>


</body>
</html>