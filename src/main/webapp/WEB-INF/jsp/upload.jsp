<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Upload One File</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>

<h3>Upload One File:</h3>

<!-- MyUploadForm -->
<form:form modelAttribute="myUploadForm" method="POST"
           action="" enctype="multipart/form-data">

    Category:
    <br>
    <form:select path="category">
        <form:options items="${categories}" itemValue="id" itemLabel="title" />
    </form:select>
    <br/><br/>

    File to upload: <form:input path="fileDatas" type="file"/><br />


    <input type="submit" value="Upload">

</form:form>

</body>

</html>