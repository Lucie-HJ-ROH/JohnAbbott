<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FormHandling</title>
</head>
<body>
<h3>Registration Form</h3>

<!--<form action="welcome-post.php" method="post">-->
<!--    Name: <input type="text" name="name"><br>-->
<!--    SurName: <input type="text" name="surname"><br>-->
<!--    Username: <input type="text" name="username"><br>-->
<!--    Password: <input type="password" name="password"><br>-->
<!--    Age: <input type="text" name="age"><br>-->
<!--    Date of Birth: <input type="date" name="dateofbirth"><br>-->
<!--    <input type="submit">-->
<!--</form>-->

<!--<form method="post" action="--><?php //echo htmlspecialchars($_SERVER['PHP_SELF']);?><!--">-->
<!---->
<!--    Name: <input type="text" name="name"><br>-->
<!--    SurName: <input type="text" name="surname"><br>-->
<!--    Username: <input type="text" name="username"><br>-->
<!--    Website: <input type="text" name="website"><br>-->
<!--    Comment: <textarea name="comment" rows="5" cols="40"></textarea><br>-->
<!--    Gender: <input type="radio" name="gender" value="female">Female-->
<!--    <input type="radio" name="gender" value="male">Male<br>-->
<!--    <input type="submit">-->
<!--</form>-->


<?php
// define variables and set to empty values
$nameErr = $emailErr = $genderErr = $websiteErr = $countryErr = $countryCodeErr = "";
$name = $email = $gender = $comment = $website = $country = $countryCode = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (empty($_POST["name"])) {
        $nameErr = "Name is required";
    } else {
        $name = test_input($_POST["name"]);
    }
    if (empty($_POST["country"])) {
        $countryErr = "Country is required";
    } else {
        $country = test_input($_POST["country"]);
        if (!preg_match("/^[A-Z]$/", $country)) {
            $countryErr = "Only letters are allowed limit 15";
        }
    }
    if (empty($_POST["countryCode"])) {
        $countryCodeErr = "Country code is required";
    } else {
        $countryCode = test_input($_POST["countryCode"]);
        if (!preg_match("/^+[0-9]{,3}$/", $countryCode)) {
            $countryErr = "Only letters are allowed limit 15";
        }

    }
//
//    if (empty($_POST["email"])) {
//        $emailErr = "Email is required";
//    } else {
//        $email = test_input($_POST["email"]);
//    }
//    if (empty($_POST["website"])) {
//        $website = "";
//    } else {
//        $website = test_input($_POST["website"]);
//    }
//    if (empty($_POST["comment"])) {
//        $comment = "";
//    } else {
//        $comment = test_input($_POST["comment"]);
//    }
//    if (empty($_POST["gender"])) {
//        $genderErr = "Gender is required";
//    } else {
//        $gender = test_input($_POST["gender"]);
//    }
}
?>

<?php
// define variables and set to empty values
$name = $email = $gender = $comment = $website = "";
function test_input($data)
{
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
//    $name = test_input($_POST["name"]);
//    $email = test_input($_POST["email"]);
//    $website = test_input($_POST["website"]);
//    $comment = test_input($_POST["comment"]);
//    $gender = test_input($_POST["gender"]);
    $country = test_input($_POST["country"]);
    $countryCode = test_input($_POST["countryCode"]);
}
?>
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
    <!--    Name: <input type="text" name="name">-->
    <!--    <span class="error">* --><?php //echo $nameErr; ?><!----><?php //echo $name; ?><!--</span>-->
    <!--    <br><br>-->
    <!--    E-mail:-->
    <!--    <input type="text" name="email">-->
    <!--    <span class="error">* --><?php //echo $emailErr; ?><!----><?php //echo $email; ?><!--</span>-->
    <!--    <br><br>-->
    <!--    Website:-->
    <!--    <input type="text" name="website">-->
    <!--    <span class="error">--><?php //echo $websiteErr; ?><!----><?php //echo $website; ?><!--</span>-->
    <!--    <br><br>-->
    <!--    <label>Comment: <textarea name="comment" rows="5" cols="40"></textarea> <br><br>-->
    <!--        Gender:-->
    <!--        <input type="radio" name="gender" value="female" checked="true">Female-->
    <!--        <input type="radio" name="gender" value="male">Male-->
    <!--        <span class="error">* --><?php //echo $genderErr; ?><!--</span>-->
    <!--        <br><br>-->
    Country: <input type="text" name="country">
    <span class="error">* <?php echo $countryErr; ?><?php echo $country; ?></span>
    <br><br>
    Country Code: <input type="text" name="countryCode">
    <span class="error">* <?php echo $countryCodeErr; ?><?php echo $countryCode; ?></span>
    <br><br>


    <input type="submit" name="submit" value="Submit">
</form>


<br>
<h3>You have successfully registered </h3>

<!--Name : --><?php //echo $_POST["name"]; ?><!--<br/>-->
<!--e-mail : --><?php //echo $_POST["email"]; ?><!--<br/>-->
<!--website : --><?php //echo $_POST["website"]; ?><!--<br/>-->
<!--comment: --><?php //echo $_POST["comment"]; ?><!--<br/>-->
<!--Gender: --><?php //echo $_POST["gender"]; ?><!--<br/>-->
Country: <?php echo $_POST["country"]; ?><br/>
Country Code: <?php echo $_POST["country_code"]; ?><br />

</body>
</html>
