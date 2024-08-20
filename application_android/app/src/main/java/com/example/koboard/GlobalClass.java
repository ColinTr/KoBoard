package com.example.koboard;

import android.app.Application;

import com.example.koboard.model.Constants;
import com.example.koboard.model.Utilisateur;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class GlobalClass extends Application{

    private static Utilisateur user = new Utilisateur("-1", "Default");
    private static String token = "";
    private static String expireDateToken = "";
    public static GoogleSignInClient mGoogleSignInClient;

    public final static String BASE_URL = "https://fcm.googleapis.com";
    public final static String SERVER_KEY = "???";
    public final static String CONTENT_TYPE = "application/json";
    public static String SPOTIFY_AUTH_TOKEN = "";
    public static boolean getPlaylist = false;

    private Socket socket;
    {
        try{
            socket = IO.socket(Constants.SERVER_URL);
        } catch (URISyntaxException e){
            throw new RuntimeException(e);
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public static Utilisateur getUser() {
        return user;
    }

    public static void setExpireDateToken(String expireDateToken) {
        GlobalClass.expireDateToken = expireDateToken;
    }

    public static void setUser(Utilisateur user) {
        GlobalClass.user = user;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        GlobalClass.token = token;
    }
}