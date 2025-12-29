package com.aluracursos.screenmatch.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

import static com.google.genai.Client.*;

public class ConsultaGemini {
        public static String obtenerTraduccion(String texto) {
            String modelo = "gemini-2.5-flash";
            String prompt = "Traduce el siguiente texto al español: " + texto;

//            Client cliente =newClient.Builder().apiKey("TU-CLAVE-API").build();
            Client cliente = new Builder().apiKey("AIzaSyAR_VCceEWh2P_N3T0KGe227k1G1LZWSro").build();

            try {
                GenerateContentResponse respuesta = cliente.models.generateContent(
                        modelo,
                        prompt,
                        null // Parámetro para configuraciones adicionales
                );

                if (!respuesta.text().isEmpty()) {
                    return respuesta.text();
                }
            }catch (Exception e) {
                System.err.println("Error al llamar a la API de Gemini para traducción: " + e.getMessage());
            }

            return null;
        }
    }

