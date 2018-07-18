private static void addLine(Path file) {
        int position = 1;
        int i = 1;
        List<String> lines = new ArrayList<>();
        String extraLine = "your line to add";
        if (file.toFile().length() > 0) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file.toString()), "windows-1252"))) {
                for (String line; (line = reader.readLine()) != null; i++) {
                    if (line.contains("the text like to add after")) position = i;
                    lines.add(line);
                }
                lines.add(position, extraLine);
                Files.write(file, lines, Charset.forName("windows-1252"));
            } catch (IOException e) {
            }
        }
    }
