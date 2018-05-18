package br.edu.ifpe.tads.pdm.chatoff;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class AdaptadorPagina extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public AdaptadorPagina(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                MensagensFragment mensagens = new MensagensFragment();
                return mensagens;
            case 1:
                ItemFragment contatos = new ItemFragment();
                return contatos;
            case 2:
                PerfilFragment perfil = new PerfilFragment();
                return perfil;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}