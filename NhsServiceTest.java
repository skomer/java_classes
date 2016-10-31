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


}