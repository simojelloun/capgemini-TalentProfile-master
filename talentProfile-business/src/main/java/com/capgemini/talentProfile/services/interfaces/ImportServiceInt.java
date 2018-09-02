package com.capgemini.talentProfile.services.interfaces;

import java.io.InputStream;

public interface ImportServiceInt {

    public void importFromSesame(final InputStream inputStream);

    public void importFromInfoRetain(final InputStream inputStream);

    public void importFromMyPathHisto(final InputStream inputStream);

    public void importFromMyPathEpp(final InputStream inputStream);

    public void importFromMyPathCed(final InputStream inputStream);

    public void importFromCollabCm(final InputStream inputStream);

    public void importFromUserRole(final InputStream inputStream);
}
