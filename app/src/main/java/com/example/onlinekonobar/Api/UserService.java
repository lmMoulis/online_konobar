package com.example.onlinekonobar.Api;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {
    @POST("api/Korisnik/login")
    Call<LoginResponse> loginUsers(@Body LoginRequest loginRequest);
    @POST("api/Korisnik")
    Call<RegisterResponse> registerUsers(@Body RegisterRequest registerRequest);
    @POST("api/StavkaControllers")
    Call<Void> saveCard(@Body Item item);
    @POST("api/RacunControllers")
    Call<Void> saveInvoice(@Body Invoice invoice);
    @PUT("api/SkladisteControllers/{id}")
    Call<Void> updateStock(@Path("id") int id, @Body Stock stock);


    @GET("api/ArtikalControllers")
    Call<ArrayList<Article>> getAllArticles();
    @GET("api/ArtikalControllers/{id}")
    Call<Article> getArticleById(@Path("id") int articleId);

    @GET("api/ArtikalControllers")
    Call<ArrayList<Article>> searchArticles(@Query("searchText") String searchText);

    @GET("api/ArtikalControllers")
    Call<ArrayList<Article>> getArticlesByCategory(@Query("kategorija_id") int categoryId);

    @GET("api/KategorijaControllers")
    Call<ArrayList<Category>> getAllCategory();
    @GET("api/PrilagodbaControllers")
    Call<ArrayList<Customize>> getAllCustomize();

    @GET("/api/SkladisteControllers/{articleId}")
    Call<Stock> getStockByArticleId(@Path("articleId") int articleId);
    @GET("api/RacunControllers/{invoiceId}")
    Call<Invoice>getInvoiceById(@Path("invoiceId") int invoiceId);

    @GET("api/Korisnik/{id}")
    Call<User> getUserById(@Path("id") int id);
    @GET("api/RacunControllers")
    Call<ArrayList<Invoice>>getAllInvoice();
    @GET("api/StavkaControllers")
    Call<ArrayList<Item>>getAllItems();

    @PUT("api/RacunControllers/{id}")
    Call<Void> stornInvoice(@Path("id") int id, @Body Invoice invoice);
}

