<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FormHandling</title>
</head>
<body>
<h3>Country Form</h3>
<?php
$country = $country_code = $postal_code = "";
$countryErr = $country_codeErr = $postal_codeErr = "";

function test_input($data)
{
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {

    if (empty($_POST["country"])) {
        $countryErr = "Country is required";
    } else {
        $country = test_input($_POST["country"]);
        if (!preg_match("/^[A-Z]{1,15}$/", $country)) {
            $countryErr = "Only uppercase letters less than 15 characters are allowed";
        }
    }

    if (empty($_POST["country_code"])) {
        $country_codeErr = "Country code is required";
    } else {
        $country_code = test_input($_POST["country_code"]);
        if (!preg_match("/^[+][0-9]{1,3}$/", $country_code)) {
            $country_codeErr = "Country codes must be less than 3 digits that start with +";
        }

    }

    if (empty($_POST["postal_code"])) {
        $postal_codeErr = "Postal code is required";
    } else {
        $postal_code = test_input($_POST["postal_code"]);
        if (!preg_match("/^[A-Z][0-9][A-Z][ -]?[0-9][A-Z][0-9]$/", $postal_code)) {
            $postal_codeErr = "1st, 3rd and 5th char are [A-Z], 2nd, 4th and 6th are the digits[0-9] ";
        }

    }
}

?>

<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
    Country: <input type="text" name="country">
    <span class="error">* <?php echo $countryErr; ?><?php echo "    " .$country; ?></span>
    <br><br>
    Country Code: <input type="text" name="country_code">
    <span class="error">* <?php echo $country_codeErr; ?><?php echo "   "  .$country_code; ?></span>
    <br><br>
    Postal Code: <input type="text" name="postal_code">
    <span class="error">* <?php echo $postal_codeErr; ?><?php echo "     " . $postal_code;?></span>
    <br><br>
    <input type="submit" name="submit" value="Submit">
</form>

</body>
</html>