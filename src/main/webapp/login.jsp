<form action="login" method="post">
  <label>RUT Ejecutivo</label><input name="rut" required />
  <label>Nombre</label><input name="nombre" required />
  <button type="submit">Ingresar</button>
  <div style="color:red">${error}</div>
</form>
