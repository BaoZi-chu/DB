<html >
<head>
<title>student adding </title>
</head>
<body >
<h2> Adding new student.</h2>
<?php
     $ID = $_POST['ID'];
     $studentname = $_POST['studentname'];
     $dept_name = $_POST['dept_name'];
	 $tot_cred=$_POST['tot_cred'];
      if(!$ID and !$studentname and !$dept_name and !$tot_cred){
            echo "Error:  There is no data passed.";
            exit;
      }
      if(!$ID or !$studentname or !$dept_name or !$tot_cred){
           echo "Error: Some data did not be passed.";
           exit;
      }
      if(!get_magic_quotes_gpc()){
         $ID = addslashes($ID);
         $studentname = addslashes($studentname);
         $dept_name = addslashes($dept_name);
		 $tot_cred=addslashes($tot_cred);
      }

          @ $db = mysqli_connect('localhost', 'root', 'FCy8849678.','uni');
      if(mysqli_connect_errno()){
       echo "Error: Could not connect to mysql database.";
       exit;
      }

          $q = "insert into student values ('$ID','$studentname','$dept_name','$tot_cred')";
          if(!mysqli_query($db, $q)){
            echo "Error: No new student has been added to database.";
          }else{
            echo "New student has been added to database.";
          };
          mysqli_close($db);

?>

</body>
</html>