class Solution {
    public String simplifyPath(String path) {
        List<String> dirs = new ArrayList<>();
        for (var dir : path.split("/")) {
            if (dir.isEmpty() || dir.equals(".")) {
                continue;
            }
            if (dir.equals("..")) {
                if (!dirs.isEmpty())
                    dirs.remove(dirs.size() - 1);
            } else {
                dirs.add(dir);
            }
        }
        
        return "/" + String.join("/", dirs);
    }
}