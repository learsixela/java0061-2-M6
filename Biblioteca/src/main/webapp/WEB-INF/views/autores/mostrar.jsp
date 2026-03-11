<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Autores</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
        <jsp:include page="/WEB-INF/views/include/navbar.jsp"></jsp:include>
        <br>
	    <h2>Crear Autor</h2>
	    <!-- formulario de creacion -->
	    <form action="/autores/guardar" method="post">
		  <div class="mb-3">
		    <label for="nombre" class="form-label">Nombre</label>
		    <input type="text" class="form-control" id="nombre" name="nombre" value="${autor.nombre}">
		  </div>
		  <div class="mb-3">
		    <label for="nacionalidad" class="form-label">Nacionalidad</label>
		    <input type="text" class="form-control" id="nacionalidad" name="nacionalidad" value="${autor.nacionalidad}">
		  </div>
			<br>
		  <button type="submit" class="btn btn-primary">Crear Autor</button>
		</form>
    	<br>
     <!-- tabla con autores -->
    <table class="table">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Nombre</th>
	      <th scope="col">Nacionalidad</th>
	      <th scope="col-2">Acciones</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach var="autor" items="${listaAutores}">
		    <tr>
		      <td><c:out value="${autor.id}"></c:out></td>
		      <td><c:out value="${autor.nombre}"></c:out></td>
		      <td><c:out value="${autor.nacionalidad}"></c:out></td>
		      <td>
		      	<a href="${pageContext.request.contextPath}/libros/editar?id=${libro.id}"
		      	
		      	class="btn btn-warning" role="button" aria-disabled="true">Editar</a>
				
				<form action="${pageContext.request.contextPath}/libros/eliminar" method="post">
					<input type="hidden" name="id" value="${libro.id}">
					<button type="submit" class="btn btn-danger"
					onclick="return confirm('Quieres eliminar el libro?');"
					>Eliminar</button>
				</form>
		      
		      </td>	
		    </tr>
		</c:forEach>

	  </tbody>
	</table>
    

    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" ></script>
  </body>
</html>