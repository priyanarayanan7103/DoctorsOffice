-- Insert specialties
INSERT INTO Specialty (specialtyName)
VALUES ('Cardiology'), ('Dermatology'), ('Endocrinology'), ('Gastroenterology');

-- Insert doctors
INSERT INTO Doctor (doctorFName, doctorLName, doctorSpecialtyId, phoneNumber, email)
VALUES
  ('John', 'Smith', 1, '555-1234', 'john@example.com'),
  ('Jane', 'Doe', 2, '555-5678', 'jane@example.com'),
  ('David', 'Johnson', 3, '555-9876', 'david@example.com'),
  ('Sarah', 'Wilson', 1, '555-4321', 'sarah@example.com'),
  ('Robert', 'Anderson', 2, '555-8765', 'robert@example.com');

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