package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class representing a folder/directory.
 */
public class CompositeFolder implements Folder {

    /** name of folder */
    final String name;

    /** list of {@link CompositeFolder} and {@link File} instances that are my sub folders*/
    ArrayList<Folder> dirs = new ArrayList<>();

    /**
     * Constructor for Main.CompositeFolder class.
     * @param name name of the new Main.CompositeFolder instance
     * @throws NullPointerException if name is null
     * @throws IllegalArgumentException if name is empty (when stripped of spaces)
     */
    public CompositeFolder(String name) throws NullPointerException, IllegalArgumentException {
        if (name == null) {
            throw new NullPointerException("Folder name cannot be null");
        }

        name = name.strip();

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Folder name cannot be empty");
        }

        this.name = name;
    }

    /**
     * Add file or folder to my sub folders.
     * @param path new path to be added.
     *             path must start with current instance's name.
     *             e.g. /curr_inst_name/.../new_folder/new_file
     */
    @Override
    public void addFolder(String path) throws NullPointerException {

        if (path == null) {
            throw new NullPointerException("path cannot be null");
        }

        // name list of folders in given a path
        final ArrayList<String> pathFoldersNames =
                new ArrayList<>(Arrays.asList(path.split("/", 0)));

        if (path.isEmpty()) {
            return;
        }

        // if I am the last folder in the given path, the path already exists
        String lastName = pathFoldersNames.getLast();
        if (this.name.equals(lastName)) {
            return;
        }

        // if the second last file in given path is me,
        // add the last file to my dirs list
        String secondLastName = pathFoldersNames.get(pathFoldersNames.size() - 2);
        if (this.name.equals(secondLastName)) {

            try {
                if (lastName.indexOf('.') != -1) {
                    dirs.add(new File(lastName));
                }
                else {
                    dirs.add(new CompositeFolder(lastName));
                }

                return;
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        Folder myDir = searchMyDirsInNextPath(pathFoldersNames);

        // the path without the next folder
        List<String> subFolderNames = pathFoldersNames.subList(1, pathFoldersNames.size());
        String subPath = String.join("/", subFolderNames);

        try {
            // if none of my folders are the next folder in given path,
            // create new folder, and it will build the remaining path
            if (myDir == null) {
                this.dirs.add(new CompositeFolder(pathFoldersNames.get(1)));
                this.dirs.getLast().addFolder(subPath);
            }
            // if the next folder in the given path is one of my folders, it will build the remaining path
            else {
                myDir.addFolder(subPath);
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    /**
     * checks if one of my folders is the next folder in given path.
     * if it is return it. otherwise return null.
     * @param pathFoldersNames list of folder names in given path
     * @return one of my files if it is next folder in given path, otherwise null.
     */
    private Folder searchMyDirsInNextPath(ArrayList<String> pathFoldersNames) {

        for (Folder dir : this.dirs) {
            if (dir.getName().equals(pathFoldersNames.get(1))) {
                return dir;
            }
        }

        return null;
    }

    /**
     * In addition to printing its path,
     * tells all its sub folders to print their own path.
     * @param prevPath the path that lead to the folder.
     *                 e.g. /root/.../directory_of_folder
     * @see Folder#printPath(String)
     */
    @Override
    public void printPath(String prevPath) {
        String myPath = prevPath + '/' + this.name;

        System.out.println("Directory: " + myPath);

        for (Folder dir : this.dirs) {
            dir.printPath(myPath);
        }
    }

    /**
     * @return the name of folder
     * @see Folder#getName()
     */
    @Override
    public String getName() {
        return name;
    }
}
