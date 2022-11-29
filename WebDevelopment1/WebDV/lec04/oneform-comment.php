<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Comment</title>
    <style>
        form div {
            margin-bottom : 10px;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <?php
        //set some empty variables
        $nameErr = $emailErr = $websiteErr = $commentErr = $genderErr = "";
        $name = $email = $website = $comment = $gender = "";

        if($_SERVER["REQUEST_METHOD"] == "POST"){
            
            if (empty($_POST["name"])){
                $nameErr = "Name is required";
            } else {
                $nameErr = "";
                $name = test_input($_POST["name"]);
                
                if(!preg_match("/^[a-zA-Z]*$/",$name)){
                    $nameErr = "Only letters and white space allowed";
                }
            }


            if (empty($_POST["email"])){
                $emailErr = "Email is required";
            } else {
                $emailErr = ""; 
                $email = test_input($_POST["email"]);
                if(!preg_match("/([\w\-]+\@[\w\-]+\.[\w\-]+)/",$email)){
                    $emailErr = "Invalid email format";
                }
            }


            if (empty($_POST["website"])){
                $websiteErr = "Website is required";
            } else {
                $websiteErr = "";
                $website = test_input($_POST["website"]);
                if(!preg_match("/(https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|www\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9]+\.[^\s]{2,}|www\.[a-zA-Z0-9]+\.[^\s]{2,})/",$website)){
                    $websiteErr = "Invalid url";
                }

                
            }


            if (empty($_POST["comment"])){
                $commentErr = "Comment is required";
            } else {   
                $commentErr = "";
                $comment = test_input($_POST["comment"]);
            }


            if (empty($_POST["gender"])){
                $genderErr = "Gender is required";
            } else {   
                $genderErr = "";
                $gender = test_input($_POST["gender"]);
            }
        }

        function test_input($data){
            $data = trim($data);
            $data = stripslashes($data);
            $data = htmlspecialchars($data);
            return $data;
        }
    ?>

    <h1>Leave a comment</h1>
    <form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']);?>" method="POST">
       
        <div> 
            Name *:  <input type="text" name="name" value="<?=(isset($name))?$name:'';?>"><br>
            <span class="error"><?=$nameErr ?></span>
        </div>
        <div> 
            Email *:  <input type="text" name="email" value="<?=(isset($email))?$email:'';?>"><br>
            <span class="error"><?=$emailErr ?></span>
        </div>
        <div> 
            Website *:  <input type="text" name="website"  value="<?=(isset($website))?$website:'';?>"><br>
            <span class="error"><?=$websiteErr ?></span>
        </div>
        <div> 
            Comment *: <br>
            <textarea name="comment" rows="4" cols="50"><?=(isset($comment))?$comment:'';?></textarea> *<br>
            <span class="error"><?=$commentErr ?></span>
        </div>
        <div> 
            Gender *: <br>
            m:<input type="radio" name="gender" value="male" <?=($gender = "male")? "checked" : "checked=\"false\"";?>>
            f:<input type="radio" name="gender" value="female" <?=($gender = "female")? "checked" : "checked=\"false\"";?>><br>
            <span class="error"><?=$genderErr ?></span>
        </div>
        
        <div> <input type="submit" name="submit" value="Submit"></div>
    </form>



    <?php
    if(isset($_POST['submit'])){
       ?>
        
        <h3>Your Comment</h3>
        <p><?=$comment;?></p>
        <p></p>
        <p> <i>-- by <?=$name;?></i> </p>
        <p><b>info:</b> <i><?=$gender;?>, <?=$email;?>, <?=$website;?></i></p>
    <?php
    }

    //echo json_encode($_POST);
    ?>
</body>
</html>