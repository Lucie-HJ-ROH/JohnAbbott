<html>
<head></head>
<body>
<h1>Coast City Bowling Tournament</h1>
<?php
if (isset($_GET['first_name']) && isset($_GET['last_name'])&& isset($_GET['grade_course'])&& isset($_GET['dob'])&& isset($_GET['gender'])) {
    $BowlerFirst = addslashes($_GET['first_name']);
    $BowlerLast = addslashes($_GET['last_name']);
    $BowlerGradeCourse = $_GET['grade_course'];
    $BowlerDob = $_GET['dob'];
    $BowlerGender = $_GET['gender'];

    $NewBowler = $BowlerLast . ", " . $BowlerFirst . ", " .$BowlerGradeCourse . ", " .$BowlerDob . ", "  . $BowlerGender . "\n";
    $BowlersFile = "bowlers.txt";
    if (file_put_contents($BowlersFile, $NewBowler, FILE_APPEND) < 0) {
       echo "<p>{$_GET['first_name']} <br> {$_GET['last_name']} <br>
                  {$_GET['grade_course']} <br> {$_GET['dob']} <br> {$_GET['gender']} been registered for the bowling tournament!</p> ";
    }else{
        echo "<p> Registration error!</p > ";
    }
} else {
    echo "<p>To sign up for the bowling tournament, enter your first and last name and click the Register button.</p >";
}

// 파일 열기
$fp = fopen("bowlers.txt", "r") or die("파일을 열 수 없습니다！");

// 파일 내용 출력
while (!feof($fp)) {
    echo fgets($fp);
}

// 파일 닫기
fclose($fp);

?>
<form action="index.php" method="get" enctype="application/x-www-form-urlencoded">
    <p>First Name: <input type="text" name="first_name" size="30"/></p>
    <p>Last Name: <input type="text" name="last_name" size="30"/></p>
    <p>Grade Course: <input type="text" name="grade_course" size="30"/></p>
    <p>Date of Birth : <input type="date" name="dob"></p>
    <p>Gender:
            <input type="radio" name="gender" value="female" checked="true">Female
            <input type="radio" name="gender" value="male">Male
    </p>
    <p><input type="submit" value="Register"/></p>
</form>
</body>

</html>