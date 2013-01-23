package fr.enseirb.odroidx.home;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;

public class Parameters extends PreferenceActivity{

	private fr.enseirb.odroidx.home.STBRemoteControlCommunication stbrcc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);
		
		final EditTextPreference etp = (EditTextPreference) findPreference("serverIP");
		etp.setSummary(etp.getText());
		etp.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
			
			public boolean onPreferenceChange(Preference preference, Object newValue) {
				etp.setSummary((String) newValue);
				return true;
			}
		});
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onStart() {
		stbrcc = new STBRemoteControlCommunication(this);
		stbrcc.doBindService();
		super.onStart();
	}

	@Override
	protected void onStop() {
		stbrcc.doUnbindService();
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
}
