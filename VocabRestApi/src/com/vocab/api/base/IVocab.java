package com.vocab.api.base;

public interface IVocab {

	public int getVocab_id();

	public void setVocab_id(int vocab_id);

	public int getVocab_type();

	public void setVocab_type(int vocab_type);

	public int getVocab_lesson();

	public void setVocab_lesson(int vocab_lesson);

	public String getVocab_en();

	public void setVocab_en(String vocab_en);

	public String getVocab_ipa();

	public void setVocab_ipa(String vocab_ipa);

	public String getVocab_vi();

	public void setVocab_vi(String vocab_vi);

	public String getVocab_description();

	public void setVocab_description(String vocab_description);

	public String getVocab_sound_url();

	public void setVocab_sound_url(String vocab_sound_url);
}
