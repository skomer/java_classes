public class NhsService {

  private String name;
  private Patient[] waitingList;

  public NhsService(String name) {
    this.name = name;
    this.waitingList = new Patient[43];
  }

  public String getName() {
    return this.name;
  }

  public int patientCount() {
    int counter = 0;
    for (Patient patientName : waitingList) {
      if (patientName != null) {
        counter++;
      }
    }
    return counter;
  }

  public void addPatient(Patient patient) {


    int nextEmptyIndex = patientCount();
    waitingList[nextEmptyIndex] = patient;
  }




}