package Main;

/**
 * Class representing a file system manager.
 * Starts with an empty root directory.
 * Can add new {@link Folder} instances to the system.
 * via given path.
 * Can print path for each {@link Folder}.
 */
public class FoldersManager {

    /** the root folder */
    Folder rootFolder;

    /** root folder name */
    final String rootName = "root";

    public FoldersManager() {
        this.rootFolder = new CompositeFolder(rootName);
    }

    /**
     * add path with new directories/files to the file system
     * @param path new path to be added.
     *             e.g. /root/.../new_folder/new_file
     */
    public void addPath(String path) {
        StringBuilder completePath = new StringBuilder(path);

        if (completePath.charAt(0) != '/') {
            completePath.insert(0, '/');
        }

        try {
            this.rootFolder.addFolder(rootName + completePath);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /** print each {@link CompositeFolder} and {@link File} instance path */
    public void printTree() {
        this.rootFolder.printPath("");
    }
}
