<?php
require "conn.php";
$user_name = $_POST["user_name"];
$full_name = $_POST["full_name"];
$user_pass = $_POST["password"];
$mysql_qry = "insert into user (username, name, password) values ('$user_name', '$full_name', '$user_pass')";
if($conn->query($mysql_qry) === TRUE){
    echo "Registration Success";
}
else{
    echo "Registration Failed";
}
$conn->close();
?>