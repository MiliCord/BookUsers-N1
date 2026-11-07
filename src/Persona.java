public class Persona {

    private String tipoDocumento;
    private String documento;
    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;
    private String rol;
    private boolean tratamiento;


    public Persona(String tipoDocumento, String documento, String nombres, String apellidos, String correo, String telefono, String rol, boolean tratamiento) {
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.rol = rol;
        this.tratamiento = tratamiento;

    }

        public boolean isTratamiento() {
            return tratamiento;
        }

        public void setTratamiento(boolean tratamiento) {
            this.tratamiento = tratamiento;
        }

        public String getRol() {
            return rol;
        }

        public void setRol(String rol) {
            this.rol = rol;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public String getNombres() {
            return nombres;
        }

        public void setNombres(String nombres) {
            this.nombres = nombres;
        }

        public String getDocumento() {
            return documento;
        }

        public void setDocumento(String documento) {
            this.documento = documento;
        }

        public String getTipoDocumento() {
            return tipoDocumento;
        }

        public void setTipoDocumento(String tipoDocumento) {
            this.tipoDocumento = tipoDocumento;
        }

    
}
