-- 1. Users Table (Linked to Supabase Auth)
CREATE TABLE users (
    user_id UUID PRIMARY KEY DEFAULT auth.uid(),
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    role VARCHAR(20) CHECK (role IN ('learner', 'tutor', 'both', 'admin')) DEFAULT 'learner',
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- 2. Tutors Profile Table
CREATE TABLE tutors (
    tutor_id SERIAL PRIMARY KEY,
    user_id UUID REFERENCES users(user_id) ON DELETE CASCADE,
    bio TEXT,
    subjects TEXT[],
    availability JSONB,
    rating NUMERIC(3,2) DEFAULT 0.00,
    verified BOOLEAN DEFAULT FALSE
);

-- 3. Sessions Table
CREATE TABLE sessions (
    session_id SERIAL PRIMARY KEY,
    tutor_id INT REFERENCES tutors(tutor_id) ON DELETE CASCADE,
    learner_id UUID REFERENCES users(user_id) ON DELETE CASCADE,
    subject VARCHAR(100) NOT NULL,
    session_date DATE NOT NULL,
    session_time TIME NOT NULL,
    status VARCHAR(20) CHECK (status IN ('Pending', 'Confirmed', 'Completed', 'Cancelled')) DEFAULT 'Pending'
);

-- 4. Feedback Table
CREATE TABLE feedback (
    feedback_id SERIAL PRIMARY KEY,
    session_id INT REFERENCES sessions(session_id) ON DELETE CASCADE,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comment TEXT
);
