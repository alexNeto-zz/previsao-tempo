package com.ts.previsao.tempo.previsao7dias;

import com.google.gson.Gson;
import com.ts.previsao.tempo.cidade.CidadeModel;
import com.ts.previsao.tempo.cidade.CidadeRepository;
import com.ts.previsao.tempo.previsao.PrevisaoModel;
import com.ts.previsao.tempo.previsao.PrevisaoRepository;

import java.util.List;

class Previsao7DiasModel {

    String getPrevisao(String uf, String cidade) throws Exception {
        CidadeModel cidadeModel = new CidadeModel();
        CidadeRepository cidadeEncontrada = cidadeModel.filtraCidade(uf, cidade);
        PrevisaoModel previsaoModel = new PrevisaoModel();
        List<PrevisaoRepository> previsoes = previsaoModel.filtraPrevisao(cidadeEncontrada.getId(),
                cidadeEncontrada.getAtualizacao());
        return new Gson().toJson(previsoes);
    }
}
