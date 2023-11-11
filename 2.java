public class GenericSearchExample {

    public static <T> boolean searchElement(T[] array, T target) {
        for (T element : array) {
            if (element.equals(target)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        int targetInt = 3;
        boolean foundInt = searchElement(intArray, targetInt);
        System.out.println("Integer " + targetInt + " found: " + foundInt);
        String[] stringArray = {"apple", "banana", "cherry", "date"};
        String targetString = "banana";
        boolean foundString = searchElement(stringArray, targetString);
        System.out.println("String '" + targetString + "' found: " + foundString);
        Student[] students = {
                new Student("John", 123),
                new Student("Alice", 456),
                new Student("Bob", 789)
        };
        Student targetStudent = new Student("Alice", 456);
        boolean foundStudent = searchElement(students, targetStudent);
        System.out.println("Student " + targetStudent + " found: " + foundStudent);
    }

    static class Student {
        private String name;
        private int id;

        public Student(String name, int id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Student student = (Student) obj;
            return id == student.id && name.equals(student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, id);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }
}
