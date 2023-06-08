-- Insert specialties
INSERT INTO Specialty (specialtyName)
VALUES ('Cardiology'), ('Dermatology'), ('Endocrinology'), ('Gastroenterology');

-- Insert doctors
INSERT INTO Doctor (doctorFName, doctorLName, doctorSpecialtyId, phoneNumber, email, imageURL)
VALUES
  ('John', 'Smith', 1, '555-1234', 'john@example.com', "https://purepng.com/public/uploads/large/purepng.com-doctorsdoctorsdoctors-and-nursesa-qualified-practitioner-of-medicine-aclinicianmedical-practitionermale-doctor-1421526856801kbvy1.png"),
  ('Jane', 'Doe', 2, '555-5678', 'jane@example.com',"https://purepng.com/public/uploads/large/purepng.com-doctordoctorsdoctors-and-nursesclinicianmedical-practitionernotepadfemale-1421526857330hticw.png"),
  ('David', 'Johnson', 3, '555-9876', 'david@example.com',"https://purepng.com/public/uploads/large/purepng.com-doctorsdoctorsdoctors-and-nursesa-qualified-practitioner-of-medicine-aclinicianmedical-practitionermale-doctor-1421526856715fcree.png"),
  ('Sarah', 'Wilson', 1, '555-4321', 'sarah@example.com',"https://purepng.com/public/uploads/large/purepng.com-doctordoctorsdoctors-and-nursesclinicianmedical-practitionernotepadfemale-1421526857295nzsqt.png"),
  ('Roxanne', 'Anderson', 2, '555-8765', 'roxanne@example.com',"https://purepng.com/public/uploads/large/purepng.com-doctordoctorsdoctors-and-nursesclinicianmedical-practitionernotepadfemale-1421526857248uragw.png");

-- Insert patients
INSERT INTO Patient (patientFName, patientLName, dateOfBirth, address, phoneNumber, email)
VALUES
  ('Emily', 'Brown', '1990-05-15', '123 Main St', '555-1111', 'emily@example.com'),
  ('Michael', 'Davis', '1985-11-02', '456 Elm St', '555-2222', 'michael@example.com'),
  ('Sophia', 'Wilson', '1978-09-10', '789 Oak St', '555-3333', 'sophia@example.com'),
  ('Olivia', 'Taylor', '1980-07-20', '321 Elm St', '555-4444', 'olivia@example.com'),
  ('Matthew', 'Wilson', '1992-02-12', '654 Oak St', '555-5555', 'matthew@example.com');

-- Insert appointments
INSERT INTO Appointment (time, doctorId, patientId, status)
VALUES
  ('2023-06-03 10:00:00', 1, 1, 'Scheduled'),
  ('2023-06-05 14:30:00', 2, 2, 'Scheduled'),
  ('2023-06-08 09:15:00', 3, 3, 'Scheduled'),
  ('2023-06-10 11:30:00', 4, 4, 'Scheduled'),
  ('2023-06-12 15:00:00', 5, 5, 'Scheduled');