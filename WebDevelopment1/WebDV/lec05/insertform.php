<html>
<head><title>DB connection</title></head>
<body>


<?php
echo "DB TEST";

$server = "localhost:3306";
$user = "hyunju";
$password = "Root2022";
$dbname = "PHPUser";

$conn = new mysqli($server, $user, $password, $dbname);

if($conn->connect_error) {
    echo "Connection error";
} else{
    echo "Connection ok";
}


//create database
//if(mysqli_query($conn,"CREATE DATABASE PHPUser")){
//    echo "Database created";
//}else{
//    echo "Database not created";
//}

//create table
//mysqli_select_db($conn,"PHPUser");
//$sql = "CREATE TABLE users(
//    username varchar(15),
//    surname varchar(15),
//    age varchar(3),
//    dob varchar(15),
//    password varchar(15))";
//
//mysqli_query($conn,$sql);
//
//


//$statement1 = "insert into users (Code,Title,prerequest) values ('cs234','AI','CS244')";
//$flag = mysqli_query($conn,$statement1);
//
//if($flag){
//    echo "SQL statement1 excuted";
//}else{
//    die("SQL statement1 NOT excuted".mysqli_error($conn));
//}

//

//
//$statement1 = "SELECT * FROM courses";
////$sql = "SELECT * FROM courses WHERE Code = 'cs234'";
//$result = mysqli_query($conn,$statement1);
//echo "the number of rows affected is : " .mysqli_num_rows($result);

//
//while($data = (mysqli_fetch_array($result))){
//
//    echo '<br> Code : ';
//    echo '  ' . $data["Code"] . ', Title : ';
//    echo '  ' . $data["Title"] . ', Prerequest : ';
//    echo '  ' . $data["prerequest"] . " ";
//    echo '<br>';
//
//}
//


//
//mysqli_query($conn,"insert into users (name,surname,age,dob,password) values ('sara','lee','62','1960-12-31','1111')");
//mysqli_query($conn,"insert into users (name,surname,age,dob,password) values ('romi','kim','52','1970-12-31','1111')");
//mysqli_query($conn,"insert into users (name,surname,age,dob,password) values ('john','park','42','1980-12-31','1111')");
//mysqli_query($conn,"insert into users (name,surname,age,dob,password) values ('emma','roh','32','1990-12-31','1111')");
//mysqli_query($conn,"insert into users (name,surname,age,dob,password) values ('riam','an','29','1995-12-31','1111')");

$username = $_POST["username"];
$surname = $_POST["surname"];
$age = $_POST["age"];
$dob = $_POST["dob"];
$password = $_POST["password"];

$statement1 = "insert into users(username,surname,age,dob,password) 
                values('$username','$surname','$age','$dob','$password')";

$result = mysqli_query($conn,$statement1);

if($result){
    echo "Record added Successfully";
}else{
    die("Can not add Record".mysqli_error());
}
//
//
$statement2 = "SELECT * FROM users";
////$sql = "SELECT * FROM courses WHERE Code = 'cs234'";
$result = mysqli_query($conn,$statement2);
//echo "the number of rows affected is : " .mysqli_num_rows($result);
//

while($data = (mysqli_fetch_array($result))){

    echo '<br> username : ';
    echo '  ' . $data["username"] . ', surname : ';
    echo '  ' . $data["surname"] . ', age : ';
    echo '  ' . $data["age"] . ', date of birth : ';
    echo '  ' . $data["dob"] . " ";
    echo '<br>';

}
mysqli_close($conn);
?>
<form method="post" action="insertform.php">
<table border="1">
    <tr>
        <td>Name</td>
        <td><input type="text" name="username"></td>
    </tr>
    <tr>
        <td>Surname</td>
        <td><input type="text" name="surname"></td>
    </tr>
    <tr>
        <td>Age</td>
        <td><input type="text" name="age"></td>
    </tr>
    <tr>
        <td>Date of birth</td>
        <td><input type="text" name="dob"></td>
    </tr>
    <tr>
        <td>Password</td>
        <td><input type="password" name="password"></td>
    </tr>
    <tr>
        <td>
            <input type="submit" value="Add User"/>
        </td>
        <td><input type="reset" /></td>
    </tr>
</table>

</form>


</body>
</html>