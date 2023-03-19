package HOME_WORK4;

class Employee implements Comparable<Employee> {
        String name;
        String position;

        public Employee(String name, String position) {
            this.name = name;
            this.position = position;
        }

        public static Employee getEmployee(String name, String position) {
            return new Employee(name, position);
        }

        public String getPosition() {
            return position;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Employee obj) {
            return (name + position).compareTo(obj.getName() + obj.getPosition());
        }

        @Override
        public String toString() {
            return name + ";" + position;
        }
}
