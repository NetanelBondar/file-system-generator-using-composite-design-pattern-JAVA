package Main;

/**
 * class interface for {@link CompositeFolder} and {@link File} classes
 */
public interface Folder {
    /**
     * adds the new folders/files in path to the system.
     * @param path new path to be added.
     *             e.g. /root/.../new_folder/new_file
     * @throws Exception if trying to add sub file to a simple file
     */
    void addFolder(String path) throws Exception;

    /**
     * Prints the whole path that lead to the folder or file.
     * e.g. Directory: /root/.../directory_of_folder/folder
     * @param prevPath the path that lead to the folder.
     *                 e.g. /root/.../directory_of_folder
     */
    void printPath(String prevPath);

    /**
     * @return the name of the directory/file
     */
    String getName();
}
