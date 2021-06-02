<html>
<head>
  <title>student found</title>
</head>
<body>
  <h2>student found from mysql database.</h2>
<?php
    $dept_name = $_POST['dept_name'];
	if(!$dept_name){
		echo "Error: There is no data passed.";
		exit;
	}
	if(!get_magic_quotes_gpc()){
		$dept_name = addslashes($dept_name);
	}
	    @ $db = mysqli_connect('localhost','root','FCy8849678.');
		 mysqli_select_db($db,'uni');
		 if(mysqli_connect_errno()){
			 echo "Error:Could not connect to mysql database.";
			 exit;
		 }
		 $q="select * from student where dept_name='".$dept_name."'";
		 $result = mysqli_query($db,$q);
		 
		 if(!$result){
				  echo "Error: Could not find ".$dept_name;
				  exit;
			  }
		 $rownum = mysqli_num_rows($result);
		 if(!$rownum){
				  echo "Error: Could not find ".$dept_name;
				  exit;
			  }
		 for($i=0; $i<$rownum; $i++){
			 $row = mysqli_fetch_assoc($result);
			 echo "Id:".$row['ID']."<br />";
			 echo "Name:".$row['name']."<br />";
			 echo "dept_name:".$row['dept_name']."<br />";
			 echo "tot_cred:".$row['tot_cred']."<br />";
			 
		 }
		 mysqli_free_result($result);
		 mysqli_close($db);
?>
</body>
</html>