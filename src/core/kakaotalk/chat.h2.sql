CREATE TABLE IF NOT EXISTS kakaotalk_chat (
    id IDENTITY PRIMARY KEY,
    ts SMALLDATETIME NOT NULL,
    name VARCHAR_IGNORECASE NOT NULL,
    message VARCHAR_IGNORECASE
);


CREATE INDEX IF NOT EXISTS ts_idx ON kakaotalk_chat (ts);
CREATE INDEX IF NOT EXISTS name_idx ON kakaotalk_chat (name);
COMMENT ON TABLE kakaotalk_chat IS 'KakaoTalk Chat';
