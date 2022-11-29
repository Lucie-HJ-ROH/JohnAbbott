<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>USER REGISTRATION</title>
    <style>
      div {
        width: 50%;
        margin: 0 auto;
        background-color: lightgray;
        padding: 10px 20px;
      }

      form {
        margin: 0 auto;
        text-align: right;
      }

      li {
        list-style: none;
      }

      input {
        width: 300px;
        height: 25px;
        margin-right: 40px;
        margin-bottom: 10px;
        vertical-align: middle;
        border: none;
      }

      input[type="submit"] {
        width: 120px !important;
        height: 40px !important;
        font-size: 20px;
        background-color: green;
        color: white;
        border: 1px solid green;
        text-align: center;
        margin-right: 300px;
      }
      span {
        width: 50%;
        margin-right: 20px;
      }
      .errMsg {
        display: inline-block;
        width: 180px;
      }
    </style>
  </head>
  <body>
    <?php
      $requiredField = "<font color='red'>*</font>";
      $email = $password = $rePassword = $fName = $lName = $phone = $address = $region = $postcode = $country = "";
      $emailErr = $passwordErr = $rePasswordErr = $fNameErr = $lNameErr =
        $phoneErr = $addressErr = $regionErr = $postcodeErr = $countryErr = "";
      if ($_SERVER["REQUEST_METHOD"] == "POST") {
        // Email
        if (empty($_POST["email"])) {
          $emailErr = "Email is required";
        } else {
          $email = test_input($_POST["email"]);
          if (!preg_match("/([\w\-]+\@[\w\-]+\.[\w\-]+)/", $email)) {
            $emailErr = "Invalid email format. <br> (‘@’ and ‘.’ chars) required";
          }
        }
        // Password
        if (empty($_POST["password"])) {
          $passwordErr = "Password is required";
        } else {
          $password = test_input($_POST["password"]);

          $uppercase = preg_match('@[A-Z]@', $password);
          $lowercase = preg_match('@[a-z]@', $password);
          $number    = preg_match('@[0-9]@', $password);
          $specialChars = preg_match('@[^\w]@', $password);

          if(!$uppercase || !$lowercase || !$number || !$specialChars || strlen($password) < 10) {
            $passwordErr = "10 chars, one upper case letter, one number, and one special character";
          }
        }

        if (empty($_POST["rePassword"])){
          $rePasswordErr = "Retype Password is required";
        } else if ($_POST["password"] == $_POST["rePassword"]){
          $rePassword = test_input($_POST["rePassword"]);
        } else {
          $rePasswordErr = "Password is not matched!!";
        }

        if (empty($_POST["fName"])){
          $fNameErr = "First name is required";
        } else {
          $fName = test_input($_POST["fName"]);
           if (!preg_match("/[A-Z]{1,10}/", $fName)){
             $fNameErr = "Invalid format. <br> 10 chars, only letters [A-Z], with no space";
          }
        }

        if (empty($_POST["lName"])){
          $lNameErr = "Last name is required";
        } else {
          $lName= test_input($_POST["lName"]);
          if (!preg_match("/[A-Z]{1,15}/", $lName)) {
            $lNameErr = "Invalid format. <br> 10 chars, only letters [A-Z].";
          }
        }

        if (empty($_POST["phone"])){
          $phoneErr = "Phone number is required";
        } else {
          $phone = test_input($_POST["phone"]);
          if (!preg_match("/^(\++[1-9]{1,15})$/", $phone)){
            $phoneErr = "Invalid format.<br> a ‘+’ followed by up to 15 digits.";
          }
        }

        if (empty($_POST["address"])) {
          $addressErr = "Address is required";
        } else {
          $address = test_input($_POST["address"]);
          if (!preg_match("/", $address)) {
            $addressErr = "Invalid format [$address]";
          }
        }

        if (empty($_POST["region"])) {
          $regionErr = "Region is required";
        } else {
          $region = test_input($_POST["region"]);
          if (!preg_match("/", $region)) {
            $regionErr = "Invalid format [$region]";
          }
        }

        if (empty($_POST["postcode"])) {
          $postcodeErr = "Postcode is required";
        } else {
          $postcode = test_input($_POST["postalCode"]);
          if (!preg_match("/^([A-Z]+[0-9]+[A-Z]+[0-9]+[A-Z]+[0-9])$/", $postcode)) {
            $postcodeErr = "Invalid postcode format [input : $postcode]";
          }
        }

        if (empty($_POST["country"])) {
          $countryErr = "Country is required";
        } else {
          $country = test_input($_POST["country"]);
          if (!preg_match("/^[A-Z]{1,15}$/", $country)) {
            $countryErr = "Only capital letters allowed, up to 15 characters [input : $country]";
          }
        }
      }
      function test_input($data)
      {
        $data = trim($data);
        $data = stripslashes($data);
        $data = htmlspecialchars($data);
        return $data;
      }

    ?>
    <div>
      <h2>USER REGISTRATION</h2>
      <p>Fields marked <?php echo $requiredField; ?> are required.</p>
      <form method="post" action="<?php echo $_SERVER["PHP_SELF"]; ?>">
        <span>Email<?php echo $requiredField; ?> </span><input type="text" name="email"><span class="errMsg"><?php echo $emailErr; ?></span> <br>
        <span>Password<?php echo $requiredField; ?></span><input type="password" name="password"><span class="errMsg"><?php echo $passwordErr; ?></span><br>
        <span>Retype Password<?php echo $requiredField; ?></span> <input type="password" name="rePassword"><span class="errMsg"><?php echo $rePasswordErr; ?></span><br>
        <span>First Name<?php echo $requiredField; ?></span> <input type="text" name="fName" ><span class="errMsg"><?php echo $fNameErr; ?></span><br>
        <span>Last Name<?php echo $requiredField; ?></span> <input type="text" name="lName" ><span class="errMsg"><?php echo $lNameErr; ?></span><br>
        <span>Phone Number<?php echo $requiredField; ?></span> <input type="tel" name="phone" ><span class="errMsg"><?php echo $phoneErr; ?></span><br>
        <span>Address<?php echo $requiredField; ?></span> <input type="text" name="address" ><span class="errMsg"><?php echo $addressErr; ?></span><br>
        <span></span><input type="text" name="address"><span class="errMsg"></span><br>
        <span>Town</span> <input type="text" name="town"><span class="errMsg"></span><br>
        <span>Region<?php echo $requiredField; ?></span> <input type="text" name="region" ><span class="errMsg"><?php echo $regionErr; ?></span><br>
        <span>Postcode / Zip<?php echo $requiredField; ?></span> <input type="text" name="postcode" ><span class="errMsg"><?php echo $postcodeErr; ?></span><br>
        <span>Country<?php echo $requiredField; ?></span> <input type="text" name="country" style="border-radius: 10px"><span class="errMsg"><?php echo $countryErr; ?></span><br>
        <input type="submit" value="Register">
      </form>
    </div>
  </body>
</html>