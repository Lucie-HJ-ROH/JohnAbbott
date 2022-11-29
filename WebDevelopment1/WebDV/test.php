<html>
<head> Welcome</head>
<!---->
<!---->
<!---->
<?php
//
//$Today = "Wednesday";
//
//if($Today == "Monday"){
//    echo "Today is Monday";
//}else if($Today == "Tuesday"){
//    echo "Today is Tuesday";
//}else if($Today == "Wednesday"){
//    echo "Today is Wednesday";
//}else if($Today == "Thursday"){
//    echo "Today is Thursday";
//}else if($Today == "Friday"){
//    echo "Today is Friday";
//}else if($Today == "Saturday"){
//    echo "Today is Saturday";
//}else{
//    echo "Today is Sunday";
//}
//
//?>
<!---->
<!--<H3>Here is your grade. </H3>-->
<?php
//$scores = 0;
//$grades = "";
//if ($scores < 60) {
//    echo "You are FAIL in this session.";
//    $grades = "Fail";
//} else if ($scores >= 60 && $scores < 70) {
//    echo "Your grade corresponds to C";
//    $grades = "C";
//} else if ($scores >= 70 && $scores < 80) {
//    echo "Your grade corresponds to B";
//    $grades = "B";
//} else if ($scores >= 80 && $scores < 90) {
//    echo "Your grade corresponds to A";
//    $grades = "A";
//} else if ($scores >= 90 && $scores == 100) {
//    echo "Your grade corresponds to A+";
//    $grades = "A+";
//}
//
//
//switch ($grades) {
//    case "A+":
//        echo "<br />Your score is between 90 and 100.";
//        break;
//    case "A":
//        echo "<br />Your score is between 80 and 89.";
//        break;
//    case "B":
//        echo "<br />Your score is between 70 and 70.";
//        break;
//    case "C":
//        echo "<br />Your score is between 60 and 69.";
//        break;
//    case "Fail" :
//        echo "<br />Your score is under 60.";
//        switch ($scores) {
//            case 40:
//                echo "<br />Your are at risk ";
//                break;
//            case 30:
//                echo "<br />Your are done ";
//            default:
//                echo "<br />I can't help you";
//        }
//        break;
//    default :
//        echo "<br />Invalid score.";
//        break;
//
//}
//
//?>


<!---->
<?php
//$age = 32;
//if($age <= 30 && $age >= 20){
//    echo "<br />You are an adult.";
//    if($age <= 25 && $age >= 20){
//        echo "<br />You are early 20 years old.";
//    }else{
//        echo "<br />You are late 20 years old.";
//    }
//}else if($age <= 40 && $age >= 31){
//    echo "<br />You are an young professional.";
//}else if($age <= 70 && $age >=50){
//    echo "<br />You deserve rest";
//}
//?>




<?php

////$count = 0;
////while($count < 20){
////    echo "<br />counter at " .$count++;
////}
////
////$count = 0;
////while($count < 20){
////    echo "<br />counter at" . ++$count ;
////}
//
//echo "<br />";
//$count = 0;
//
//
//echo "<br />  do while -  ";
//do{
//    echo "  " . ++$count ;
//}while($count < 20);
//
//
//echo "<br />  for  -    ";
//$count = 0;
//for($count = 0; $count <20; $count++){
//    echo "  " . $count ;
//
//}
//
//echo "<br />  foreach  -    ";
//
//$count = range(1,20);
//foreach($count as $value){
//    echo "  " . $value ;
//}
//
//
//$DayOfWeek = array("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
//echo "<br /> DayOfWeek - ";
//foreach($DayOfWeek as $value){
//    echo " " . $value . " ";
//}


//$testNumber = 50;
//
//if(isEven($testNumber)){
//    echo "<br /> this is true";
//}else{
//    echo "<br /> this is false";
//}
//
//
//function isEven($number) : bool{
//    $check = false;
//
//    if($number%2 == 0){
//        $check = true;
//        echo "<br /> this is even number " . $number;
//
//
//    }else{
//        $check = false;
//        echo "<br /> this is odd number " . $number;
//    }
//
//    echo "<br /> check " . $check ;
//
//    return $check;
//
//}

$arrayNum = array(2 ,3,6,5,1);

function sum($arrayNum) {
    $sum = 0;
    foreach($arrayNum as $number) {
        $sum += $number;
    }
    return $sum;
}

echo "<br/> the sume is " .  sum($arrayNum);

function highestNum($arrayNum) {
    $highest = 0;
    $temp = $arrayNum[0];

    rsort($arrayNum);
    echo "<br/>" . $arrayNum[0] . " is the highest ";

    foreach($arrayNum as $number) {
        if($temp<$number) {
            $highest = $number;
            $temp = $highest;
        }
    }
    return $highest;
}

echo "<br/> the highest number is " . highestNum($arrayNum);

?>




</html>
