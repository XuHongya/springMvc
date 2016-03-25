<html>
<body>
<h2>Hello World!</h2>

<form action="rest/user/1" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="put">
</form>

<form action="rest/user/1" method="post">
    <input type="submit" value="post">
</form>

<form action="rest/user/1" method="get">
    <input type="submit" value="get">
</form>

<form action="rest/user/1" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="delete">
</form>

</body>
</html>
