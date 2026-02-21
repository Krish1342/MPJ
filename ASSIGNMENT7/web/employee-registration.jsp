<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Employee Registration</title>
  </head>
  <body>
    <h2>Employee Registration Form</h2>
    <form action="registerEmployee" method="post">
      <label>Name:</label>
      <input type="text" name="name" required /><br /><br />

      <label>Email:</label>
      <input type="email" name="email" required /><br /><br />

      <label>Department:</label>
      <input type="text" name="department" required /><br /><br />

      <label>Salary:</label>
      <input type="number" step="0.01" name="salary" required /><br /><br />

      <button type="submit">Register</button>
    </form>
  </body>
</html>
