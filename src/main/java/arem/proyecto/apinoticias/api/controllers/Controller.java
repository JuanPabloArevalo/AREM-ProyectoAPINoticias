/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arem.proyecto.apinoticias.api.controllers;

import arem.proyecto.apinoticias.api.model.Articulo;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Juan Pablo Arévalo y Stefany Moron
 */
@RestController
@RequestMapping(value = "/APINoticias/V1/news")
public class Controller {

    @RequestMapping(path = "/CNN", method = RequestMethod.GET)
    public ResponseEntity<?> getNoticiasCNNEs() {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://newsapi.org/v2/top-headlines?sources=cnn-es&apiKey=eb29210794c24d798995ffe5d4a652fb");
        Set<Articulo> map = new HashSet<>();
        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity, "UTF-8");
            JSONObject jsonObject = new JSONObject(content);
            JSONArray arregloJs = jsonObject.getJSONArray("articles");
            Articulo articulo;
            String titulo, autor, descripcion, fecha, url, imagen;
            for (int i = 0; i < arregloJs.length(); i++) {
                articulo = new Articulo();
//Titulo
                try {
                    titulo = arregloJs.getJSONObject(i).getString("title");
                } catch (JSONException e) {
                    titulo = "";
                }
                articulo.setTitulo(titulo);
//Autor               
                try {
                    autor = arregloJs.getJSONObject(i).getString("author");
                } catch (JSONException e) {
                    autor = "";
                }
                articulo.setAutor(autor);
//Descripcion
                try {
                    descripcion = arregloJs.getJSONObject(i).getString("description");
                } catch (JSONException e) {
                    descripcion = "";
                }
                articulo.setDescripcion(descripcion);
//Fecha Publicacion 
                try {
                    fecha = arregloJs.getJSONObject(i).getString("publishedAt");
                } catch (JSONException e) {
                    fecha = "";
                }

                articulo.setFechaPublicacion(fecha);
//URL
                try {
                    url = arregloJs.getJSONObject(i).getString("url");
                } catch (JSONException e) {
                    url = "";
                }
                articulo.setUrl(url);
//URL Imagen
                try {
                    imagen = arregloJs.getJSONObject(i).getString("urlToImage");
                } catch (JSONException e) {
                    imagen = "";
                }
                articulo.setUrlImagen(imagen);
                map.add(articulo);
            }
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/elMundo", method = RequestMethod.GET)
    public ResponseEntity<?> getNoticiasElMundo() {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://newsapi.org/v2/top-headlines?sources=el-mundo&apiKey=eb29210794c24d798995ffe5d4a652fb");
        Set<Articulo> map = new HashSet<>();
        try {
            System.out.print("ACA");
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity, "UTF-8");
            JSONObject jsonObject = new JSONObject(content);
            JSONArray arregloJs = jsonObject.getJSONArray("articles");
            Articulo articulo;
            String titulo, autor, descripcion, fecha, url, imagen;
            for (int i = 0; i < arregloJs.length(); i++) {
                articulo = new Articulo();
//Titulo
                try {
                    titulo = arregloJs.getJSONObject(i).getString("title");
                } catch (JSONException e) {
                    titulo = "";
                }
                articulo.setTitulo(titulo);
//Autor               
                try {
                    autor = arregloJs.getJSONObject(i).getString("author");
                } catch (JSONException e) {
                    autor = "";
                }
                articulo.setAutor(autor);
//Descripcion
                try {
                    descripcion = arregloJs.getJSONObject(i).getString("description");
                } catch (JSONException e) {
                    descripcion = "";
                }
                articulo.setDescripcion(descripcion);
//Fecha Publicacion 
                try {
                    fecha = arregloJs.getJSONObject(i).getString("publishedAt");
                } catch (JSONException e) {
                    fecha = "";
                }

                articulo.setFechaPublicacion(fecha);
//URL
                try {
                    url = arregloJs.getJSONObject(i).getString("url");
                } catch (JSONException e) {
                    url = "";
                }
                articulo.setUrl(url);
//URL Imagen
                try {
                    imagen = arregloJs.getJSONObject(i).getString("urlToImage");
                } catch (JSONException e) {
                    imagen = "";
                }
                articulo.setUrlImagen(imagen);
                map.add(articulo);
            }
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/laGaceta", method = RequestMethod.GET)
    public ResponseEntity<?> getNoticiasLaGaceta() {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://newsapi.org/v2/top-headlines?sources=la-gaceta&apiKey=eb29210794c24d798995ffe5d4a652fb");
        Set<Articulo> map = new HashSet<>();
        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity, "UTF-8");
            JSONObject jsonObject = new JSONObject(content);
            JSONArray arregloJs = jsonObject.getJSONArray("articles");
            Articulo articulo;
            String titulo, autor, descripcion, fecha, url, imagen;
            for (int i = 0; i < arregloJs.length(); i++) {
                articulo = new Articulo();
//Titulo
                try {
                    titulo = arregloJs.getJSONObject(i).getString("title");
                } catch (JSONException e) {
                    titulo = "";
                }
                articulo.setTitulo(titulo);
//Autor               
                try {
                    autor = arregloJs.getJSONObject(i).getString("author");
                } catch (JSONException e) {
                    autor = "";
                }
                articulo.setAutor(autor);
//Descripcion
                try {
                    descripcion = arregloJs.getJSONObject(i).getString("description");
                } catch (JSONException e) {
                    descripcion = "";
                }
                articulo.setDescripcion(descripcion);
//Fecha Publicacion 
                try {
                    fecha = arregloJs.getJSONObject(i).getString("publishedAt");
                } catch (JSONException e) {
                    fecha = "";
                }

                articulo.setFechaPublicacion(fecha);
//URL
                try {
                    url = arregloJs.getJSONObject(i).getString("url");
                } catch (JSONException e) {
                    url = "";
                }
                articulo.setUrl(url);
//URL Imagen
                try {
                    imagen = arregloJs.getJSONObject(i).getString("urlToImage");
                } catch (JSONException e) {
                    imagen = "";
                }
                articulo.setUrlImagen(imagen);
                map.add(articulo);
            }
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/marca", method = RequestMethod.GET)
    public ResponseEntity<?> getNoticiasMarca() {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://newsapi.org/v2/top-headlines?sources=marca&apiKey=eb29210794c24d798995ffe5d4a652fb");
        Set<Articulo> map = new HashSet<>();
        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity, "UTF-8");
            JSONObject jsonObject = new JSONObject(content);
            JSONArray arregloJs = jsonObject.getJSONArray("articles");
            Articulo articulo;
            String titulo, autor, descripcion, fecha, url, imagen;
            for (int i = 0; i < arregloJs.length(); i++) {
                articulo = new Articulo();
//Titulo
                try {
                    titulo = arregloJs.getJSONObject(i).getString("title");
                } catch (JSONException e) {
                    titulo = "";
                }
                articulo.setTitulo(titulo);
//Autor               
                try {
                    autor = arregloJs.getJSONObject(i).getString("author");
                } catch (JSONException e) {
                    autor = "";
                }
                articulo.setAutor(autor);
//Descripcion
                try {
                    descripcion = arregloJs.getJSONObject(i).getString("description");
                } catch (JSONException e) {
                    descripcion = "";
                }
                articulo.setDescripcion(descripcion);
//Fecha Publicacion 
                try {
                    fecha = arregloJs.getJSONObject(i).getString("publishedAt");
                } catch (JSONException e) {
                    fecha = "";
                }

                articulo.setFechaPublicacion(fecha);
//URL
                try {
                    url = arregloJs.getJSONObject(i).getString("url");
                } catch (JSONException e) {
                    url = "";
                }
                articulo.setUrl(url);
//URL Imagen
                try {
                    imagen = arregloJs.getJSONObject(i).getString("urlToImage");
                } catch (JSONException e) {
                    imagen = "";
                }
                articulo.setUrlImagen(imagen);
                map.add(articulo);
            }
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(path = "/laNacion", method = RequestMethod.GET)
    public ResponseEntity<?> getNoticiasLaNacion() {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://newsapi.org/v2/top-headlines?sources=la-nacion&apiKey=eb29210794c24d798995ffe5d4a652fb");
        Set<Articulo> map = new HashSet<>();
        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity, "UTF-8");
            JSONObject jsonObject = new JSONObject(content);
            JSONArray arregloJs = jsonObject.getJSONArray("articles");
            Articulo articulo;
            String titulo, autor, descripcion, fecha, url, imagen;
            for (int i = 0; i < arregloJs.length(); i++) {
                articulo = new Articulo();
//Titulo
                try {
                    titulo = arregloJs.getJSONObject(i).getString("title");
                } catch (JSONException e) {
                    titulo = "";
                }
                articulo.setTitulo(titulo);
//Autor               
                try {
                    autor = arregloJs.getJSONObject(i).getString("author");
                } catch (JSONException e) {
                    autor = "";
                }
                articulo.setAutor(autor);
//Descripcion
                try {
                    descripcion = arregloJs.getJSONObject(i).getString("description");
                } catch (JSONException e) {
                    descripcion = "";
                }
                articulo.setDescripcion(descripcion);
//Fecha Publicacion 
                try {
                    fecha = arregloJs.getJSONObject(i).getString("publishedAt");
                } catch (JSONException e) {
                    fecha = "";
                }

                articulo.setFechaPublicacion(fecha);
//URL
                try {
                    url = arregloJs.getJSONObject(i).getString("url");
                } catch (JSONException e) {
                    url = "";
                }
                articulo.setUrl(url);
//URL Imagen
                try {
                    imagen = arregloJs.getJSONObject(i).getString("urlToImage");
                } catch (JSONException e) {
                    imagen = "";
                }
                articulo.setUrlImagen(imagen);
                map.add(articulo);
            }
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
