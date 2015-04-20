package fr.appli.qcm.app.services;

import java.io.*;


public class FichierService {
    /**
     * La fonction serialise permet de serialiser un object dans un fichier
     * @param serializable
     * @param nomFichier
     * @return boolean
     */
    public static boolean serialise(Serializable serializable , String nomFichier)
    {
        try
        {
            File file = new File(nomFichier);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            ObjectOutputStream objectOutputStream  = new ObjectOutputStream(bufferedOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.flush();
            objectOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * La fonction deserialise permet de derialiser un fichier déjà serialisé.
     * @param nomFichier
     * @return Object|null
     */
    public static Object deserialise(String nomFichier)
    {
        try
        {
            File file = new File(nomFichier);
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            ObjectInputStream objectInputStream  = new ObjectInputStream(bufferedInputStream);
            Object objet = objectInputStream.readObject();
            objectInputStream.close();
            return objet;
        }catch (Exception e){
            return null;
        }
    }

}
