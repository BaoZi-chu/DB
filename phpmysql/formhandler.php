<html>

<head>
<title> User found</title>
</head>

<body>
<h2>User found from musql database.</h2>
<?php
$username=$_POST['username'];
if(!$username){
	echo "Error:There is no data passed.";
	exit;
}
if(!get_magic_quotes_gpc()){
	$username=addslashes($username);
}
@ $db=mysqli_connect('localhost','root','FCy8849678.','uni');
	if(mysqli_connect_errno()){
		echo "Error:Could not connect to mysql database";
		exit;
	}
	$q="select * from student where name ='".$username."'";
	$result=mysqli_query($db,$q);
	$rownum=mysqli_num_rows($result);
	if (!$rownum) {
 echo "Error:Could not find ".$username;

}

	for($i=0;$i<$rownum;$i++){
		$row=mysqli_fetch_assoc($result);
		echo "Id:".$row['ID']."<br/>";
		echo "Name:".$row['name']."<br/>";
	}

	mysqli_free_result($result);
	mysqli_close($db);
?>
</body>
</html>