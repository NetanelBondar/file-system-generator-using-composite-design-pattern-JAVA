package Main;

import java.io.IOException;

/**
 * Class representing a simple file.
 */
public class File implements Folder {

    /** name of file */
    final String name;

    /**
     * @param name name of the new File instance
     * @throws NullPointerException if name is null
     * @throws IllegalArgumentException if name is empty (when stripped of spaces)
     */
    public File(String name) throws NullPointerException, IllegalArgumentException {

        if (name == null) {
            throw new NullPointerException("File name cannot be null");
        }

        name = name.strip();

        if (name.isEmpty()) {
            throw new IllegalArgumentException("File name cannot be empty");
        }

        this.name = name;
    }



    /**
     * a folder or file can't be sub files to a file.
     * @see Folder#addFolder(String)
     * @exception Exception can't add any files under a simple file
     */
    @Override
    public void addFolder(String path) throws Exception {
        throw new Exception(String.format("Can't add the path '%s' in the simple file '%s'", path, this.name));
    }

    /**
     * @see Folder#printPath(String) 
     */
    @Override
    public void printPath(String prevPath) {
        System.out.println("File:" + " ".repeat(6) + prevPath + '/' + this.name);
    }

    /**
     * @return the name of file
     * @see Folder#getName()
     */
    @Override
    public String getName() {
        return name;
    }
}
