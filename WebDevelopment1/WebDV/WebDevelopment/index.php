<html>
<head><title>file handling</title></head>
<h1>Coast City Bowling Tournament</h1>
<?php
if (isset($_GET['first_name']) && isset($_GET['last_name'])) {
    $BowlerFirst = $_GET['first_name'];
    $BowlerLast = $_GET['last_name'];
    $NewBowler = $BowlerLast .","  . "$BowlerFirst" . "\n";
     $BowlersFile = "bowlers.txt";
     if (file_put_contents($BowlersFile, $NewBowler, FILE_APPEND) > 0)
         echo "<p>{$_GET['first_name']} {$_GET['last_name']} has
             been registered for the bowling tournament!</p>";
else
echo "<p>Registration error!</p>;
} else
?>
<form action="BowlingTournament.php" method="get">


      enctype="application/x-www-form-urlencoded">
    <p>First Name: <input type="text" name="first_name" size="30" /></p>
    <p>Last Name: <input type="text" name="last_name" size="30" /></p>
    <p><input type="submit" value="Register" /></p>
</form>
echo "<p>To sign up for the bowling tournament, enter your first
    and last name and click the Register button.</p>";
</html>