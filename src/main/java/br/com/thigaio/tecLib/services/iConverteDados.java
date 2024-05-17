package br.com.thigaio.tecLib.services;

public interface iConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
