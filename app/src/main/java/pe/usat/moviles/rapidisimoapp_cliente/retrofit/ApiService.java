package pe.usat.moviles.rapidisimoapp_cliente.retrofit;

import pe.usat.moviles.rapidisimoapp_cliente.response.DetalleSolicitudResponse;
import pe.usat.moviles.rapidisimoapp_cliente.response.SolicitudListadoActivasResponse;
import pe.usat.moviles.rapidisimoapp_cliente.response.SolicitudListadoClienteResponse;
import pe.usat.moviles.rapidisimoapp_cliente.response.SolicitudListadoResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    /*
    @FormUrlEncoded
    @POST("/login")
    Call<LoginResponse> login(@Field("email") String email, @Field("clave") String clave);

    @GET("/ciudad/listar")
    Call<CiudadListadoResponse> listarCiudad();

    @FormUrlEncoded
    @POST("/cliente/insertar")
    Call<ClienteInsertarReponse> insertarCliente(@Field("nombre") String nombre, @Field("direccion") String direccion, @Field("email") String email, @Field("ciudad_id") String ciudadId);


    */
    @FormUrlEncoded
    @POST("/solicitud/conductor")
    Call<SolicitudListadoActivasResponse> listadoSolicitudesAtendidas(@Field("conductor_id") int conductorId);

    @GET("/solicitud/listar/0")
    Call<SolicitudListadoResponse> listadoSolicitudes();

    @GET("/solicitud/detalle/{solicitudId}")
    Call<DetalleSolicitudResponse> obtenerDetalleSolicitud(@Path("solicitudId") int solicitudId);

    @GET("/solicitud/listar/{clienteId}")
    Call<SolicitudListadoClienteResponse> listadoSolicitudesCliente(@Path("clienteId") int solicitudId);

}
