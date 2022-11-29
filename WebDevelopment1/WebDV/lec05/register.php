<?php

$server = "localhost:3306";
$user = "hyunju";
$password = "1234";
$dbname = "PHPUser";

$con = new mysqli($server, $user, $password, $dbname);
if($con->connect_error) {
    echo "Connection error";
} else{
    echo "Connection ok";
}


$name = $_POST['name'];
$surname = $_POST['surname'];
$username = $_POST['username'];
$password = $_POST['password'];
$age = $_POST['age'];
$dob = $_POST['date_birth'];
//$con = mysqli_connect("localhost:3306", "localhost:3306","", "PHPUser", "80");
if (!$con) {
    echo "Error connecting  ";
    die("Connection error:" . mysqli_connect_errno());
}
mysqli_select_db($con, "PHPUser");
$statment1 = "insert into users(username,surname,age,dob,password)values(
                     '$username','$surname','$age','$dob','$password')";
$flag = mysqli_query($con, $statment1);
if ($flag) {
    echo "Record added Successfully";
} else {
    die("Can not add Record" . mysqli_error($con));
}
?>