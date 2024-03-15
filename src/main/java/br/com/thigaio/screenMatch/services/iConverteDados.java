package br.com.thigaio.screenMatch.services;

public interface iConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
