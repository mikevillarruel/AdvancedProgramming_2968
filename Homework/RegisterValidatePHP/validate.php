<?php
	if($_GET)
	{
		$servername = "localhost";
		$username = "root";
		$passwordDB = "";
		$dbname = "lab9";
		
		$user = $_GET['user'];
		$userType = $_GET['userType'];
		$password = $_GET['password'];

		// Create connection
		$conn = new mysqli($servername, $username, $passwordDB, $dbname);
		// Check connection
		if ($conn->connect_error) {
			die("Connection failed: " . $conn->connect_error);
		} 
		$myquery="SELECT * from users where user = '".$user."'";
		$result = $conn->query($myquery);
		
		if ($result->num_rows>0) {
			$row = $result->fetch_assoc();
			if($row["password"] === $password && $row["userType"] === $userType){
				echo "Valid User";
			}else{
				echo "Invalid User";
			}
		} else {
			echo "User not found";
		}

		$conn->close();		
	}
	
?>