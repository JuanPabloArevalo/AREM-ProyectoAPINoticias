/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arem.proyecto.apinoticias.api.controllers;

import arem.proyecto.apinoticias.api.model.Articulo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
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
            for(int i=0; i<arregloJs.length(); i++){
                articulo = new Articulo();
                articulo.setTitulo(arregloJs.getJSONObject(i).getString("title"));
                articulo.setAutor(arregloJs.getJSONObject(i).getString("author"));
                articulo.setDescripcion(arregloJs.getJSONObject(i).getString("description"));
                articulo.setFechaPublicacion(arregloJs.getJSONObject(i).getString("publishedAt"));
                articulo.setUrl(arregloJs.getJSONObject(i).getString("url"));
                articulo.setUrlImagen(arregloJs.getJSONObject(i).getString("urlToImage"));
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
        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);
            return new ResponseEntity<>(content, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/laGaceta", method = RequestMethod.GET)
    public ResponseEntity<?> getNoticiasLaGaceta() {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://newsapi.org/v2/top-headlines?sources=la-gaceta&apiKey=eb29210794c24d798995ffe5d4a652fb");
        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);
            return new ResponseEntity<>(content, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/marca", method = RequestMethod.GET)
    public ResponseEntity<?> getNoticiasMarca() {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://newsapi.org/v2/top-headlines?sources=marca&apiKey=eb29210794c24d798995ffe5d4a652fb");
        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);
            return new ResponseEntity<>(content, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/laNacion", method = RequestMethod.GET)
    public ResponseEntity<?> getNoticiasLaNacion() {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://newsapi.org/v2/top-headlines?sources=la-nacion&apiKey=eb29210794c24d798995ffe5d4a652fb");
        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);
            return new ResponseEntity<>(content, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}
