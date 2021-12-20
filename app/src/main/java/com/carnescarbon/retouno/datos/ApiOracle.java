package com.carnescarbon.retouno.datos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.carnescarbon.retouno.adaptadores.*;
import com.carnescarbon.retouno.casos_uso.CasoUsoProductoHome;
import com.carnescarbon.retouno.entidades.ProductosHome;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ApiOracle {

    private RequestQueue queue;
    private Context context;
    private CasoUsoProductoHome casoUsoProductoHome;
    //private String urlProdutosHome = "https://g4c5a7eb22d6797-androidreto5.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/sucursales/sucursales";
    private String urlProdutosHome = "https://gedf051d40d5c36-appcinco.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/productos/productos";


    public ApiOracle(Context context) {
        this.queue = Volley.newRequestQueue(context);
        this.context = context;
        casoUsoProductoHome = new CasoUsoProductoHome();
    }

    //  1.Request.Method(POST,PUT,DELETE,GET), 2.URL, 3.JSON, 4.REQUEST, 5.ERROR

   //METOD get All
    public void getAllProductoHome(GridView gridView, ProgressBar progressBar){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlProdutosHome, null,
                new Response.Listener<JSONObject>() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("items");
                            ArrayList<ProductosHome> list = new ArrayList<>();
                            for(int i=0; i<jsonArray.length(); i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                byte[] image = casoUsoProductoHome.stringToByte(jsonObject.getString("image"));

                       ProductosHome productosHome = new ProductosHome(
                                jsonObject.getInt("id"),
                                jsonObject.getString("name"),
                                jsonObject.getString("description"),
                                jsonObject.getString("location"),
                                image
                        );
                        list.add(productosHome);
                    }
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                    ProductoHomeAdapter productoHomeAdapter = new ProductoHomeAdapter(context, list);
                    gridView.setAdapter(productoHomeAdapter);

                } catch (JSONException error) {
                    error.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonObjectRequest);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void insertProductHome(String name, String description, String location, ImageView imageView){
        JSONObject json = new JSONObject();
        String image = casoUsoProductoHome.imageViewToString(imageView);
        try {
            json.put("name", name);
            json.put("description", description);
            json.put("location", location);
            json.put("image",image);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, urlProdutosHome, json, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonObjectRequest);
    }


    public void deleteProductHome(String id){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.DELETE, urlProdutosHome + "/" + id, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonObjectRequest);
    }

    public void getProductById(String id, ImageView imageView, EditText name, EditText description, TextView location, GoogleMap googleMap){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlProdutosHome + "/" + id, null, new Response.Listener<JSONObject>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    byte[] image = casoUsoProductoHome.stringToByte(jsonObject.getString("image"));

                   ProductosHome productosHome = new ProductosHome(
                            jsonObject.getInt("id"),
                            jsonObject.getString("name"),
                            jsonObject.getString("description"),
                            jsonObject.getString("location"),
                            image
                    );
                    byte[] imageSuc = productosHome.getImage();
                    Bitmap bitmap = BitmapFactory.decodeByteArray(imageSuc, 0, imageSuc.length);
                    imageView.setImageBitmap(bitmap);
                    name.setText(productosHome.getName());
                    description.setText(productosHome.getDescription());
                    location.setText(productosHome.getLocation());
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(productosHome.locationToCoord());
                    markerOptions.title(productosHome.getName());
                    googleMap.clear();
                    googleMap.addMarker(markerOptions);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonObjectRequest);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void updateProductHome(String id, String name, String description, String location, ImageView imageView){

        JSONObject json = new JSONObject();
        String image = casoUsoProductoHome.imageViewToString(imageView);

        try {
            json.put("id", id);
            json.put("name", name);
            json.put("description", description);
            json.put("location", location);
            json.put("image", image);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, urlProdutosHome, json, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonObjectRequest);
    }



}
