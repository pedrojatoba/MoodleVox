package com.example.moodlevox;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.example.moodlevox.entidades.Comandos;
import com.example.moodlevox.util.Util;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.speech.tts.TextToSpeech.OnUtteranceCompletedListener;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity implements OnInitListener,
		OnUtteranceCompletedListener {

	private static final int VOICE_RECOGNITION_REQUEST_CODE = 1;
	// Para falar
	private TextToSpeech tts;
	private int menu=0;
	private String comando = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		testaSuportaReconhecimento();
		
		// Inicializa o TextToSpeech
		tts = new TextToSpeech(this, this);
	}

	private void testaSuportaReconhecimento() {
		PackageManager pm = getPackageManager();
		List<ResolveInfo> activities = pm.queryIntentActivities(new Intent(
				RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
		if (activities.size() == 0) {
			Toast.makeText(this, "Não suporta reconhecimento de voz",
					Toast.LENGTH_LONG).show();
			finish();
		}
	}

	private void recognize() {
		//Ao reconhecer para a fala (testar)
		tts.stop();
		// Criação do Intent para chamar o reconhecimento de voz
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		// Indicação do modelo de linguagem
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
				RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		// Definição da mensagem que irá aparecer
		intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Fale.");
		intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
		// Inicio da Activity de reconhecimento de voz do Google
		startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
        Toast.makeText(MainActivity.this,comando, Toast.LENGTH_SHORT).show();
	}

	// Método executado ao receber o resultado da Activity de reconhecimento de
	// voz da google
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// Testa se conseguiu reconhecer a fala
		if (requestCode == VOICE_RECOGNITION_REQUEST_CODE
				&& resultCode == RESULT_OK) {
			// Receber as palavras ditas
			ArrayList<String> matches = data
					.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			// Separar o texto em palavras
			comando = matches.get(0).toString().split(" ")[0];
    

			Comandos c = Util.Acao(menu, comando);
			menu = c.getMenu();
			speak(c.getTexto());
			
			recognize();
		}
	}

	// Matar o processo de fala ao final da execução da APP
	@Override
	protected void onDestroy() {
		if (tts != null) {
			tts.stop();
			tts.shutdown();
		}

		super.onDestroy();
	}

	@Override
	public void onUtteranceCompleted(String utteranceId) {
		Log.i("TesteVoz", utteranceId);
	}

	// Método para iniciar o TextToSpeech
    @Override
    public void onInit(int code) {
        if (code == TextToSpeech.SUCCESS) {
            tts.setLanguage(Locale.getDefault());
            speak("Bem vindo ao Teste do Moodle Voz. Diga qual comando você deseja executar. 1 Disciplinas ou 2 Mensagens");
            recognize();
        } else {
            tts = null;
            Toast.makeText(this, "Failed to initialize TTS engine.",
                    Toast.LENGTH_SHORT).show();
        }
    }


	// Método para falar com o TextToSpeech
	private void speak(String text) {
		if (tts != null && text != null) {
			while (tts.isSpeaking()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
			try {
				//medir o letras/segundo 8???
				int tempo = text.length() / 8;
				Thread.sleep(tempo*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
