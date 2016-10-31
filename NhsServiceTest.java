import static org.junit.Assert.assertEquals;
import org.junit.*;

public class NhsServiceTest {

  NhsService nhsService;
  Patient patient;

  @Before
  public void before() {
    nhsService = new NhsService("Orthopaedics");
    patient = new Patient();
  }

  @Test
  public void hasName() {
    assertEquals("Orthopaedics", nhsService.getName());
  }

  @Test
  public void waitingListStartsEmpty() {
    assertEquals(0, nhsService.patientCount());
  }

  @Test
  public void patientCanJoinWaitingList() {
    nhsService.addPatient(patient);
    assertEquals(1, nhsService.patientCount());
  }

  @Test
  public void cantJoinWhenListFull() {
    for (int i = 0; i < 100; i++) {
      nhsService.addPatient(patient);
    }
    assertEquals(43, nhsService.patientCount());
  }

  @Test
  public void listDecreasesAfterTreatment() {
    for (int i = 0; i < 43; i++) {
      nhsService.addPatient(patient);
    }
    assertEquals(43, nhsService.patientCount());

    for (int i = 0; i < 5; i++) {
      nhsService.treatPatient(patient);
    }
    assertEquals(38, nhsService.patientCount());
  }



}







