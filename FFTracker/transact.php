<?php
require "conn.php";
$RecordHolder_ID = $_POST["RecordHolder_ID"];
$Amount = $_POST["Amount"];
$Date = $_POST["Date"];
$Type = $_POST["Type"];
$Category = $_POST["Category"];
$Description = $_POST["Description"];
$mysql_qry = "insert into transactions (RecordHolder_ID, Amount, Date, Type, Category, Description) values ('$RecordHolder_ID', '$Amount', '$Date', '$Type', '$Category', '$Description')";
if($conn->query($mysql_qry) === TRUE){
    echo "Record Added";
}
else{
    echo "Record Failed";
}
$conn->close();
?>