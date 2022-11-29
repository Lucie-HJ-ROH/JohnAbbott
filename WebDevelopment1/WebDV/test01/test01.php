<html>
<head><title>Test 01 : Hyunju Roh </title></head>
<style>
    form {
        background-color: lightgray;
        width: 80%;

    }
</style>
<body>

<?php
if (isset($_GET['$email']) && isset($_GET['$password']) &&isset($_GET['repassword']) && isset($_GET['first_name']) && isset($_GET['last_name']) &&  isset($_GET['phonenumber'])
    && isset($_GET['address']) && isset($_GET['town']) && isset($_GET['zip']) && isset($_GET['country']))
{

    $emailError = $passwordError = $repasswordError = $first_nameError = $last_nameError = $phonenumberError =
    $addressError = $townError = $regionError = $zipError = $countryError = "";

    $email =  $_GET['email'];
    $password = $_GET['password'];
    $repassword = $_GET['repassword'];
    $first_name = $_GET['first_name'];
    $last_name = $_GET['last_name'];
    $phonenumber = $_GET['phonenumber'];
    $address = $_GET['address'];
    $town = $_GET['town'];
    $zip = $_GET['zip'];
    $country = $_GET['country'];


        if (empty($email)) {
            $emailError = "Email is required";
        } else {
            $email = test_input($email);
            if (!preg_match("/([\w\-]+\@[\w\-]+\.[\w\-]+)/", $email)) {
                $emailErr = "Invalid email format";
                echo $emailError;
            }
        }


    function test_input($data)
    {
        $data = trim($data);
        $data = stripslashes($data);
        $data = htmlspecialchars($data);
        return $data;
    }
}

?>

<form action="test01.php" method="get" enctype="application/x-www-form-urlencoded">
    <h1>USER REGISTRATION</h1>
    <h4> Fields marked * are required.</h4>
    <p>Email * <input type="text" name="email" size="30" value="<?=(isset($email))?$email:'';?>"/>
       </p>
    <p>Passeword * <input type="password" name="password" size="30"/></p>
    <p>Retype Password * <input type="password" name="repassword" size="30"/></p>
    <p>First Name * <input type="text" name="first_name" size="30"/></p>
    <p>Last Name * <input type="text" name="last_name" size="30"/></p>
    <p>Phone Number * <input type="text" name="phonenumber" size="30"/></p>
    <p>Address * <input type="text" name="address" size="30"/>
        <br> <input type="text" name="address2" size="30"/></p>
    <p>town <input type="text" name="town" size="30"/></p>
    <p>region * <input type="text" name="region" size="30"</p>
    <p>Postcode/Zip * <input type="text" name="postcode" size="30"></p>
    <p>country * <input type="text" name="country" size="30"/></p>


    <p><input type="submit" value="Register"/></p>
</form>


<?php
if(isset($_POST['submit'])){
    ?>

    <h3>Your Comment</h3>
    <p><?=$emailError;?></p>
       <?php
}

//echo json_encode($_POST);
?>
</body>
</html>
