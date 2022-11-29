
<html>
<body>
<?php

$server = "localhost:3306";
$user = "root";
$password = "Root2022";
$dbname = "aast";

$conn = new mysqli($server, $user, $password, $dbname);

if($conn->connect_error) {
    echo "Connection error";
} else{
    echo "Connection ok";
}


?>
<form method="post" action="formquery.php">
    <p>Course Code?</p>
    <select name="course_code" id="course_code" >
        <option>CS433</option>
        <option>CS244</option>
        <option>CC231</option>
    </select>

    <input type="submit" name="submit" value="Check Prerequest"/>
    <input type="reset" name="reset" value="Reset form"/>
    </form>
</form>
<?php

if(isset($_POST["course_code"])) {
    $courseCode = $_POST["course_code"];
    $query = "SELECT prerequest from courses where Code = '$courseCode'";
    $result = mysqli_query($conn, $query);
    if(!($result)){
        echo "Error: " . mysqli_error($conn);
        die("Can not excute" . mysqli_error($conn));
    }
    $row = mysqli_fetch_array($result);
    $answer =$row["prerequest"];
    echo "<p> The prerequest for $courseCode is $answer<p>";
}
?>
</body>
</html>